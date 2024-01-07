package uk.co.jemos.podam.test.unit.features.randomness;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.annotations.Title;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import uk.co.jemos.podam.api.PodamUtils;
import uk.co.jemos.podam.test.unit.AbstractPodamSteps;

/**
 * Created by daivanov on 05/02/2017.
 */
@ExtendWith(SerenityJUnit5Extension.class)
public class RandomnessTest extends AbstractPodamSteps {

	@Test
	@Title("Podam should generate evenly distributed random integers")
	public void podamShouldGenerateEvenlyDistributedRandomIntegers() throws Exception {
		final int cnt = 10;
		final int runs = 1000000;
		int[] counters = new int[cnt];

		for (int i = 0; i < runs; i++) {
			int idx = (int)PodamUtils.getLongInRange(0, cnt - 1);
			counters[idx]++;
		}

		double mse = 0;
		double expected = runs / cnt;
		for (int i = 0; i < cnt; i++) {
			double error = 100 * (counters[i] - expected) / expected;
			mse += (error * error / cnt);
		}
		podamValidationSteps.theDoubleValueShouldBeBetween(mse, 0.0, 1.0);
	}

}
