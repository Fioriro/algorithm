package com.algorithm.greedy.meetingroom;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoom {
    class Program{
        int start;
        int end;

        public Program(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static int bestArrange(Program[] programs, int timePoint){
        Arrays.sort(programs, new Comparator<Program>() {
            @Override
            public int compare(Program o1, Program o2) {
                return o1.end - o2.end;
            }
        });
        int result = 0;
        for (int i = 0; i < programs.length; i++) {
            if(timePoint <= programs[i].start){
                result++;
                timePoint = programs[i].end;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MeetingRoom meetingRoom = new MeetingRoom();

        // Test case 1: No overlapping programs
        Program[] programs1 = {
                meetingRoom.new Program(1, 3),
                meetingRoom.new Program(4, 6),
                meetingRoom.new Program(7, 9)
        };
        System.out.println(bestArrange(programs1, 0)); // Expected output: 3

        // Test case 2: All programs overlap
        Program[] programs2 = {
                meetingRoom.new Program(1, 6),
                meetingRoom.new Program(2, 5),
                meetingRoom.new Program(3, 4)
        };
        System.out.println(bestArrange(programs2, 0)); // Expected output: 1

        // Test case 3: Some programs overlap
        Program[] programs3 = {
                meetingRoom.new Program(1, 3),
                meetingRoom.new Program(2, 4),
                meetingRoom.new Program(5, 7)
        };
        System.out.println(bestArrange(programs3, 0)); // Expected output: 2

        // Test case 4: Single program
        Program[] programs4 = {
                meetingRoom.new Program(1, 3)
        };
        System.out.println(bestArrange(programs4, 0)); // Expected output: 1

        // Test case 5: No programs
        Program[] programs5 = {};
        System.out.println(bestArrange(programs5, 0)); // Expected output: 0
    }
}


