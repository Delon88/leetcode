package LC.SOL;

public class TrafficLightControlledIntersection {
    class TrafficLight {
        private volatile int currentRoadId;

        public TrafficLight() {
            this.currentRoadId = 1;
        }

        public void carArrived(
                int carId,           // ID of the car
                int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
                int direction,       // Direction of the car
                Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
                Runnable crossCar    // Use crossCar.run() to make car cross the intersection
        ) {

            synchronized (this) {
                if (this.currentRoadId != roadId) {
                    this.currentRoadId = roadId;
                    turnGreen.run();
                }
                crossCar.run();
            }
        }
    }
}
