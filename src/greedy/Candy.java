package greedy;

import java.util.Arrays;

/**
 * 将所有孩子的糖果数初始化为1
 * 先从左往右遍历一遍，如果右边孩子的评分比左边高，则右边孩子的糖果数更新为左边孩子糖果数+1，否则保持不变
 * 再从右向左遍历一遍，如果左边孩子的评分比右边高，则左边孩子的糖果数更新为 max(右边孩子糖果数+1,原值）
 */

public class Candy {

    public static void main(String[] args) {
        System.out.println(new Candy().candy(new int[]{1, 3, 4, 5, 2}));
    }

    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        for(int i = 0; i < ratings.length; i++) {
            if(i-1 < 0) candy[i] = 1;
            else if(ratings[i] > ratings[i-1]) candy[i] = candy[i-1] + 1;
            else candy[i] = 1;
        }
        for(int i = ratings.length-2; i >= 0; i--) {
            if(ratings[i] > ratings[i+1]) candy[i] = Math.max(candy[i], candy[i+1] + 1);
        }
        return Arrays.stream(candy).sum();
    }
}
