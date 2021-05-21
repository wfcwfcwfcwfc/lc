package io.fengchao.leetcode.problems;

public class GeneSimilarity {

    public static void main(String[] args) {
        String s1 = "60T30A40T20A40G10C";
        String s2 = "30T60A20G30T30G30C";
        GeneSimilarity geneSimilarity = new GeneSimilarity();
        String ans = geneSimilarity.compute(s1, s2);
        System.out.println(ans);
    }
    public String compute(String Gene1, String Gene2) {
        // write your code here
        //初始化状态是什么？
        Gene g1 = new Gene(Gene1);
        g1.getNext();

        Gene g2 = new Gene(Gene2);
        g2.getNext(); //Iterator 设计不熟练

        int tlen = 0;
        int mlen = 0;

        //结束条件思考 到底什么情况下结束 需要想仔细
        while(g1.hasNext() && g2.hasNext()) {
            //start with easiest
            if(g1.len == g2.len) {
                mlen += (g1.base == g2.base ? g1.len : 0);
                tlen += g1.len;
                g1.getNext();
                g2.getNext();
            } else if (g1.len > g2.len) {
                mlen += (g1.base == g2.base ? g2.len : 0);
                g1.len -= g2.len;
                tlen += g2.len;
                g2.getNext();
            } else {
                mlen += (g1.base == g2.base ? g1.len : 0);
                g2.len -= g1.len;
                tlen += g1.len;
                g1.getNext();

            }
        }

        return mlen + "/" + tlen;



    }

    class Gene {
        char[] seq;
        int len;
        char base;
        int index;

        public Gene(String str) {
            seq = str.toCharArray();
            index = 0;
        }

        public void getNext() {
            if(index >= seq.length) {
                len = -1;
                return;
            }
//            len = seq[index++] - '0'; 有可能不止一位数字 哎
            len = 0;
            while(index < seq.length && Character.isDigit(seq[index])) {
                len = 10 * len + seq[index] - '0';
                index++;
            }
            base = seq[index++];
            System.out.println(len+"" + base);
        }

        public boolean hasNext() {
            return len != -1;
        }

    }

}
