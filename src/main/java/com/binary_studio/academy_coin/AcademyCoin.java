package com.binary_studio.academy_coin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public final class AcademyCoin {

	private AcademyCoin() {
	}

	public static int maxProfit(Stream<Integer> prices) {
		// TODO: Implement
        List<Integer> list = new ArrayList<Integer>();


        prices.forEach(p->list.add(p));
        list.forEach(p-> System.out.print(p+" "));
        System.out.println();
        int many = 0;
        int now;
        int plusOne;
        int plusTwo;
        /*System.out.println(list.size());*/
        for(int i =0;i<list.size()-1;){
            now = list.get(i);
            plusOne = list.get(i+1);

            if(i==list.size()-2){
                System.out.println("предпоследний");
                if(now<plusOne){
                    many+=plusOne-now;
                    break;
                }
                break;
            }
            System.out.println(i);
            plusTwo = list.get(i+2);
            if(now> plusOne&&now> plusTwo){
                System.out.println("Они меньше");
                i=i+1;
            }else if(plusOne>plusTwo){
                System.out.println("первый");
                many+=plusOne-now;
                i=i+2;
            }else if(plusOne<plusTwo){
                System.out.println("второй");
                many+=(plusTwo-now);
                i=i+3;
            }
        }
        return many;
    }

	public static void main(String[] args) {
		int mass[] = new int[]{};
		List list = new ArrayList<Integer>(Arrays.asList(7, 1, 4, 5, 1, 5, 7, 3, 9));

		maxProfit(list.stream());
	}

}
