public class Main {

    public static class Location {
        String name;
        double x;
        double y;
        String type;

        public Location(String name,String type1,  double x, double y) {
            this.name = name;
            this.x = x;
            this.y = y;
            this.type=type1;
        }

        public void setName(String name) { this.name = name; }
        public String getName() { return name; }

        public String getType() { return type; }
        public void setType(String type) { this.type = type; }

        public double getX() { return x; }
        public void setX(double x1) { x = x1; }

        public double getY() { return y; }
        public void setY(double y1) { y = y1; }

        @Override
        public String toString() {
            return "Location{" + "name='" + name + '\'' + ", type=" + type +
                    ", x=" + x + ", y=" + y + '}';
        }

    }
    public static class Road {
        String type;
        double length;
        int speedLimit;
        Location NodA;
        Location NodB;


        public Road(String type, double length, int speedLimit,Location NodA,Location NodB) {
            this.type = type;
            this.speedLimit = speedLimit;
            this.length=length;
            this.NodA=NodA;
            this.NodB=NodB;
        }
        private double EuclideanDist() {
            if (NodA == null || NodB == null) return 0;
            return Math.sqrt(Math.pow(NodA.getX() - NodB.getX(), 2) + Math.pow(NodA.getY() - NodB.getY(), 2));
        }

        public double getLength() { return length; }

        public void setLength(double length) {
            double minLength = EuclideanDist();
            if (length < minLength) {
                System.out.println("lungime prea mica " + minLength);
                this.length = minLength;
            } else {
                this.length = length;
            }
        }

        public String getType() { return type; }
        public void setType(String type) { this.type = type; }

        public int getSpeedLimit() { return speedLimit; }
        public void setSpeedLimit(int speedLimit) { this.speedLimit = speedLimit; }

        public Location getNodA() { return NodA; }
        public void setNodA(Location nodeA) { this.NodA = NodA; }

        public Location getNodB() { return NodB; }
        public void setNodB(Location nodeB) { this.NodB = NodB; }

        @Override
        public String toString() {
            return "Road{" + "type=" + type + ", length=" + length + ", speedLimit=" + speedLimit +
                    " nodeA=" + NodA.getName() + ", nodeB=" + NodB.getName()  + '}';
        }
    }
    public static void main(String[] args) {
        Location Bucuresti = new Location("bucuresti", "city", 0, 0);
        Location iasi = new Location("iasi", "city", 3, 4);

        Road drum = new Road("express", 4, 100, Bucuresti, iasi);

        System.out.println(Bucuresti);
        System.out.println(drum);
    }
}