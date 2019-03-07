import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

@RunWith(JUnitQuickcheck.class)
public class WalletPropertyBasedTest {
	
	@BeforeClass
	public static void setUp() {
		org.apache.log4j.BasicConfigurator.configure();
	}

	@Property(trials=100)
	public void onlyOnesReturnNumBills(@From(WalletGenerator.class) Wallet w)
			throws Exception {

		assumeTrue(w.getFives()==0);
		assumeTrue(w.getTens()==0);
		assumeTrue(w.getTwenties()==0);
		assumeTrue(w.getHundreds()==0);
		assertEquals(w.getAmount(), w.getOnes(), "Amount: "+w.getAmount());
		
	}
}

