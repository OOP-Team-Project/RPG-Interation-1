public abstract class Occupation {

    protected int baseStrength;
    protected int strengthIncrement;

    protected int baseAgility;
    protected int agilityIncrement;

    protected int baseIntellect;
    protected int intellectBase;

    protected double movementSpeed;

    public abstract void PerformAbility();

	protected int getBaseStrength() {
		return baseStrength;
	}

	protected int getStrengthIncrement() {
		return strengthIncrement;
	}

	protected int getBaseAgility() {
		return baseAgility;
	}

	protected int getAgilityIncrement() {
		return agilityIncrement;
	}

	protected int getBaseIntellect() {
		return baseIntellect;
	}

	protected int getIntellectIncrement() {
		return intellectBase;
	}

	protected double getMovementSpeed() {
		return movementSpeed;
	}
}