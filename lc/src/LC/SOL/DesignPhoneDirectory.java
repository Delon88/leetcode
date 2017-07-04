package LC.SOL;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by nanhong on 12/11/2016.
 */
public class DesignPhoneDirectory {
    public class PhoneDirectory {

        int max;
        LinkedList<Integer> free;
        Set<Integer> inUse;
        /** Initialize your data structure here
         @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
        public PhoneDirectory(int maxNumbers) {
            this.max = maxNumbers;
            free = new LinkedList<>();
            for ( int i = 0 ;  i < maxNumbers; i++) {
                free.add(i);
            }
            inUse = new HashSet<>();
        }

        /** Provide a number which is not assigned to anyone.
         @return - Return an available number. Return -1 if none is available. */
        public int get() {
            if ( !free.isEmpty()) {
                Integer num = free.removeFirst();
                inUse.add(num);
                return num;
            } else{
                return -1;
            }
        }

        /** Check if a number is available or not. */
        public boolean check(int number) {
            return !inUse.contains(number);
        }

        /** Recycle or release a number. */
        public void release(int number) {
            if ( inUse.contains(number)) {
                inUse.remove(number);
                free.add(number);
            }
        }
    }
}
