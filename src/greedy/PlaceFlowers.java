package greedy;

import java.util.ArrayList;
import java.util.List;

public class PlaceFlowers {

    public static void main(String[] args) {
        boolean flag = new PlaceFlowers().canPlaceFlowers(new int[]{1,0,0,0,1}, 1);
        System.out.println(flag);
    }

    //考虑了各种边界问题写出来的
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        if(flowerbed.length == 1) {
            if(flowerbed[0] == 0) count++;
        } else {
            for(int i = 0; i < flowerbed.length; i++) {
                if(i == 0) {
                    if(flowerbed[i] == 0 && flowerbed[i+1] == 0) {
                        flowerbed[i] = 1;
                        count++;
                    }
                } else if(i < flowerbed.length-1) {
                    if(flowerbed[i] == 0 && flowerbed[i-1] == 0 && flowerbed[i+1] == 0) {
                        flowerbed[i] = 1;
                        count++;
                    }
                } else if(i == flowerbed.length-1) {
                    if(flowerbed[i] == 0 && flowerbed[i-1] == 0) {
                        flowerbed[i] = 1;
                        count++;
                    }
                }
            }
        }
        return count >= n;
    }

    //在前后都增加了一个1，这样就不用那么麻烦地判断中界条件了
    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        List<Integer> flowers = new ArrayList<>();
        flowers.add(0);
        for(int flower : flowerbed) {
            flowers.add(flower);
        }
        flowers.add(0);
        int count = 0;
        for(int i = 1; i < flowers.size()-1; i++) {
            if(flowers.get(i) == 0 && flowers.get(i-1) == 0 && flowers.get(i+1) == 0) {
                flowers.set(i, 1);
                count++;
            }
        }
        return count >= n;
    }
}
