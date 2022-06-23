package com.gokhantamkoc.javabootcamp.odevhafta3.repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.gokhantamkoc.javabootcamp.odevhafta3.util.TimeUtils;

import com.gokhantamkoc.javabootcamp.odevhafta3.model.Candle;

public class CryptoDataCSVRepository implements CSVRepository {
	
	private final String COMMA_DELIMITER = ",";

	@Override
	public List<Candle> readCSV(String filename) throws FileNotFoundException, IOException {
		List<Candle> candles = new ArrayList<Candle>();
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(filename);
		// Bu alandan itibaren kodunuzu yazabilirsiniz
		
		InputStreamReader ourInputStreamreader = new InputStreamReader(inputStream);
			try (BufferedReader bufferedReader = new BufferedReader(ourInputStreamreader)) {
		    String line;
		    bufferedReader.readLine();
		    while ((line = bufferedReader.readLine()) != null) {
		    	
		        String[] values = line.split(COMMA_DELIMITER);
		        
		        candles.add(new Candle(Long.parseLong(values[0]), 
		        		Double.parseDouble(values[3]), Double.parseDouble(values[4]),
		        		Double.parseDouble(values[5]), Double.parseDouble(values[6]),
		        		Double.parseDouble(values[7])));
		    }
		}
		
		// Bu alandan sonra kalan kod'a dokunmayiniz.
		return candles;
	}

}
