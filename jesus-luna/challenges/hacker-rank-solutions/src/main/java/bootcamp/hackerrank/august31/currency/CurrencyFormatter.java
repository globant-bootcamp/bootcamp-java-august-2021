package bootcamp.hackerrank.august31.currency;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import bootcamp.hackerrank.Solution;

public class CurrencyFormatter extends Solution {

	private static final Logger log = LogManager.getLogger(CurrencyFormatter.class.getName());

	private static final String PAYMENT_AMOUNT_OUTLINE = "Give a double number of payment: ";
	private static final String PAYMENT_AMOUNT_INVALID_MSG = "Payment must be a number between 0 - 10,000,000,000: ";

	@Override
	public void solve() {
		double paymentWithOutcurrency = Solution.readDoubleInput(CurrencyFormatter.PAYMENT_AMOUNT_OUTLINE);
		log.info("10 a la potencia 9: {}", Math.pow(10, 9));
		if (paymentWithOutcurrency < 0 || paymentWithOutcurrency > Math.pow(10, 9)) {
			log.error(CurrencyFormatter.PAYMENT_AMOUNT_INVALID_MSG);
			solve();
		}
		formatCurrency(paymentWithOutcurrency);
	}

	public void formatCurrency(Double payment) {
		String[] isoCountries = Locale.getISOCountries();
		Map<String, String> countriesMap = Arrays.asList(isoCountries).stream()
				.map(isoCountry -> new Locale("", isoCountry))
				.collect(Collectors.toMap(Locale::getDisplayCountry, Locale::getCountry));
		NumberFormat numberFormatIndia = NumberFormat.getCurrencyInstance(new Locale("en", countriesMap.get("India")));
		NumberFormat numberFormatUsa = NumberFormat.getCurrencyInstance(Locale.US);
		NumberFormat numberFormatChinese = NumberFormat.getCurrencyInstance(Locale.CHINA);
		NumberFormat numberFormatFrance = NumberFormat.getCurrencyInstance(Locale.FRANCE);
		log.info("US: {}", numberFormatUsa.format(payment));
		log.info("India: {}", numberFormatIndia.format(payment));
		log.info("China: {}", numberFormatChinese.format(payment));
		log.info("France: {}", numberFormatFrance.format(payment));
	}

}
