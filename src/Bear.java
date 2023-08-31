public class Bear extends Toy {
        private int id;
        private String name;
        static double rarity = 0.6;


        public Bear() {
                this.id = count++;
                this.name = "Bear";
        }
        @Override
        public String toString() {
                return "Bear{" +
                        "name='" + name + '\'' +
                        ", rarity=" + rarity + ", id=" + id +
                        '}';
        }

        public int getId() {
        return id;
        }

        public String getName() {
                return name;
        }

        public double getRarity() {
                return rarity;
        }

}
