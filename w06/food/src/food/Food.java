package food;

import java.util.Objects;

public class Food {

    private String name;
    private double carbohydrateShare;
    private double fatShare;
    private double proteinShare;

    public Food (String name, double carbohydrateShare, double fatShare, double proteinShare) {
        if(carbohydrateShare + fatShare + proteinShare > 1) {
            throw new IllegalArgumentException("Nutrients sum up to more than 1");
        }
        this.name = name;
        this.carbohydrateShare = carbohydrateShare;
        this.fatShare = fatShare;
        this.proteinShare = proteinShare;
    }

    public double relativeEnergyDensity() {
        return (this.carbohydrateShare * 17 + this.fatShare * 37 + this.proteinShare * 17); 
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object r) {
    	// Make sure r class is also a food class (equals this class)
    	// and that both names are the same.
        return this.getClass() == r.getClass() && this.name.equals(((Food) r).getName());
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }
    
    public String toString() {
    	return this.name;
    }
}
