package io.fengchao.leetcode.problems;

import java.util.LinkedList;
import java.util.List;

public class ExamRooms {

  private List<Integer> seats;
  private int seatnum;
  public ExamRooms(int N) {
    seats = new LinkedList<>();
    seatnum = N;

  }

  public int seat() {
    int pos = 0;
    if(seats.size() == 0) {
      insert(0);
      return pos;
    }
    int dis = Integer.MIN_VALUE;

    for(int i = seats.size() - 1; i >= 1; i--) {
      int mid = seats.get(i - 1) + (seats.get(i) - seats.get(i - 1)) / 2;
      int ldis = Math.min(seats.get(i) - mid, mid - seats.get(i - 1));
      if(ldis >= dis) {
        pos = mid;
        dis = ldis;
      }
    }

    if(seatnum - 1 - seats.get(seats.size() - 1) >= dis) {
      pos = seatnum - 1;
      dis = seatnum - 1 - seats.get(seats.size() - 1);
    }
    if(seats.get(0) >= dis) {
      pos = 0;
    }
    insert(pos);
    return pos;
  }

  public void leave(int p) {
    for(int i = 0; i < seats.size(); i++) {
      if(seats.get(i) == p) {
        seats.remove(i);
        break;
      }
    }
  }

  private void insert(int val) {
    if(seats.size() == 0) {
      seats.add(val);
    }
    for(int i = 0; i < seats.size(); i++) {
      if(val > seats.get(i)) {
        seats.add(i + 1, val);
      }
      break;
    }
  }

  public static void main(String[] args) {
    ExamRooms examRooms = new ExamRooms(10);
    System.out.println(examRooms.seat());
    System.out.println(examRooms.seat());
    System.out.println(examRooms.seat());
    examRooms.leave(4);
    System.out.println(examRooms.seat());

  }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
