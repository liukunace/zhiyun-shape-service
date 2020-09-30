package com.zhiyun.sys.shape.utils;

import ch.hsr.geohash.GeoHash;

import java.io.File;
import java.io.FileInputStream;
import java.util.BitSet;
import java.util.HashMap;
public class Geohash {
    private static int numbits = 6 * 5;
    final static char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'm', 'n', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
    final static HashMap<Character, Integer> lookup = new HashMap<Character, Integer>();
    static {
        int i = 0;
        for (char c : digits)
            lookup.put(c, i++);
    }
    public static void main(String[] args) throws Exception{
        System.out.println(new Geohash().encode(45, 125));

        double[] dddd=new Geohash().decode("wx4gfbe");
        System.out.println(dddd);
        double[] dddd2=new Geohash().decode("yb0bh2n0p058");
        System.out.println(dddd2);

        System.out.println("----------------------------------------");

        // 根据经纬度生成GeoHash对象，参数分别是纬度、经度、GeoHash长度
        GeoHash geoHash = GeoHash.withCharacterPrecision(30.651006, 120.999966, 12);
        // 输出GeoHash值
        //System.out.println(geoHash.toBase32());
        //鸟巢	116.402843,39.999375	wx4g8c9v
        //水立方	116.3967,39.99932	wx4g89tk
        //故宫	116.40382,39.918118	wx4g0ffe
        geoHash = GeoHash.withCharacterPrecision(39.999375, 116.402843, 12);
        System.out.println(geoHash.toBase32());

        String xx=geoHash.toBase32();

        double lat = geoHash.getPoint().getLatitude();
        double lon = geoHash.getPoint().getLongitude();

        double lat1=GeoHash.fromGeohashString("wx4g89tk").getPoint().getLatitude();
        System.out.println(lat1);

        System.out.println(lat+"------------"+lon);



    }

    public static double distance(double lat1, double lng1, double lat2, double lng2) {
        double EARTH_RADIUS=1.0;
        double x1 = Math.cos(lat1) * Math.cos(lng1);
        double y1 = Math.cos(lat1) * Math.sin(lng1);
        double z1 = Math.sin(lat1);
        double x2 = Math.cos(lat2) * Math.cos(lng2);
        double y2 = Math.cos(lat2) * Math.sin(lng2);
        double z2 = Math.sin(lat2);
        double lineDistance =
                Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) + (z1 - z2) * (z1 - z2));
        double realDistance = EARTH_RADIUS * Math.PI * 2 * Math.asin(0.5 * lineDistance) / 180;
        return realDistance;
    }

    public double[] decode(String geohash) {
        StringBuilder buffer = new StringBuilder();
        for (char c : geohash.toCharArray()) {
            int i = lookup.get(c) + 32;
            buffer.append( Integer.toString(i, 2).substring(1) );
        }
        BitSet lonset = new BitSet();
        BitSet latset = new BitSet();
//even bits
        int j =0;
        for (int i=0; i< numbits*2;i+=2) {
            boolean isSet = false;
            if ( i < buffer.length() )
                isSet = buffer.charAt(i) == '1';
            lonset.set(j++, isSet);
        }
//odd bits
        j=0;
        for (int i=1; i< numbits*2;i+=2) {
            boolean isSet = false;
            if ( i < buffer.length() )
                isSet = buffer.charAt(i) == '1';
            latset.set(j++, isSet);
        }
        double lon = decode(lonset, -180, 180);
        double lat = decode(latset, -90, 90);
        return new double[] {lat, lon};
    }
    private double decode(BitSet bs, double floor, double ceiling) {
        double mid = 0;
        for (int i=0; i<bs.length(); i++) {
            mid = (floor + ceiling) / 2;
            if (bs.get(i))
                floor = mid;
            else
                ceiling = mid;
        }
        return mid;
    }
    public String encode(double lat, double lon) {
        BitSet latbits = getBits(lat, -90, 90);
        BitSet lonbits = getBits(lon, -180, 180);
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < numbits; i++) {
            buffer.append( (lonbits.get(i))?'1':'0');
            buffer.append( (latbits.get(i))?'1':'0');
        }
        return base32(Long.parseLong(buffer.toString(), 2));
    }
    private BitSet getBits(double lat, double floor, double ceiling) {
        BitSet buffer = new BitSet(numbits);
        for (int i = 0; i < numbits; i++) {
            double mid = (floor + ceiling) / 2;
            if (lat >= mid) {
                buffer.set(i);
                floor = mid;
            } else {
                ceiling = mid;
            }
        }
        return buffer;
    }
    public static String base32(long i) {
        char[] buf = new char[65];
        int charPos = 64;
        boolean negative = (i < 0);
        if (!negative)
            i = -i;
        while (i <= -32) {
            buf[charPos--] = digits[(int) (-(i % 32))];
            i /= 32;
        }
        buf[charPos] = digits[(int) (-i)];
        if (negative)
            buf[--charPos] = '-';
        return new String(buf, charPos, (65 - charPos));
    }
}