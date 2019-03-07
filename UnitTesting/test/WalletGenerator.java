import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

public class WalletGenerator extends Generator<Wallet> {

	public WalletGenerator() {
		super(Wallet.class);
	}

	@Override public Wallet generate(
			SourceOfRandomness r,
			GenerationStatus status) {
		
		return new Wallet(r.nextInt(1000),0,0,0,0);
	}

}
