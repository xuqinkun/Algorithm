package chapter05;

/**
 * Copyright (C), 2018-2020
 * FileName: StringSearch
 * Author:   Xu Qinkun
 * Date:     2020/3/23 9:49
 * Description:
 */

public class KMPSearch {

    public static int search(String pat, String txt) {
        int j, M = pat.length();
        int i, N = txt.length();
        int[] next = new int[M + 1];
        getNext(pat, next);
        for (i = 0, j = 0; i < N && j < M; i++) {
            if (pat.charAt(j) == txt.charAt(i)) j++;
            else {
                j = next[i + 1];
                i--;
            }
        }
        if (j == M) return  i - M;
        else return N;
    }

    private static void getNext(String pat, int [] next) {
        int i = 1, t = 0;
        next[1] = 0;
        int n = next.length;
        while (i < n - 1) {
            if (t == 0 || pat.charAt(i) == pat.charAt(t)) {
                next[i + 1] = t + 1;
                t++;
                i++;
            } else {
                t = next[t];
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(KMPSearch.search("ABABAAABABAA", "ABABAABABAAABABAA"));
    }
}
