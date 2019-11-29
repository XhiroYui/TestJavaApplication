class Lcg {
	private final long modulus;
	private final int multiplier;
	private final int increment;
	private long seed;

	public Lcg(long modulus, int multiplier, int increment, long seed) {
		this.modulus = modulus;
		this.multiplier = multiplier;
		this.increment = increment;
		this.seed = seed;
	}

	// @NotThreadSafe
	public /* synchronized */ long next() {
		// Y = (a.X + c) mod m
		long val = (multiplier * seed) + increment;
		seed = val % modulus;
		return seed;
	}
}
