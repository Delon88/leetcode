package LC.FB;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Dinusaur {

    class Dino {
        String name;
        double stride;
        double speed;

        Dino(String name, double stride) {
            this.name = name;
            this.stride = stride;
        }
    }

    public void printDino() {
        Map<String, Dino> map = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("/Users/admin/Documents/FBPE/code/dataset2.csv"))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] cols = line.split(",");
                if (cols[2].equals("bipedal")) map.put(cols[0], new Dino(cols[0], Double.parseDouble(cols[1])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        PriorityQueue<Dino> q = new PriorityQueue<>((d1, d2) -> Double.valueOf(d2.speed).compareTo(d1.speed));
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/admin/Documents/FBPE/code/dataset1.csv"))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] cols = line.split(",");
                if (map.containsKey(cols[0])) {
                    Dino d = map.get(cols[0]);
                    double leg = Double.parseDouble(cols[1]);
                    d.speed = ( d.stride / leg - 1) * Math.sqrt(leg * 9.8);
                    q.offer(d);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        while ( !q.isEmpty()) {
            Dino d = q.poll();
            System.out.println(d.name + "," + d.speed);
        }
    }

    double speed(double leg_length, double stride_length) {
        return (stride_length / leg_length - 1) * Math.sqrt(leg_length * 9.8);
    }

    public static void main(String[] args ) {
        new Dinusaur().printDino();
    }

}
