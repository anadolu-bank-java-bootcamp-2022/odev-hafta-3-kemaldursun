package com.gokhantamkoc.javabootcamp.odevhafta3.service;

import java.io.IOException;
import java.util.List;

import com.gokhantamkoc.javabootcamp.odevhafta3.model.Candle;
import com.gokhantamkoc.javabootcamp.odevhafta3.repository.CSVRepository;
import com.gokhantamkoc.javabootcamp.odevhafta3.util.chart.CandleStickChart;

public class ChartService {
	
	CSVRepository cryptoDataCSVRepository;
	
	public ChartService(CSVRepository cryptoDataCSVRepository) {
		this.cryptoDataCSVRepository = cryptoDataCSVRepository;
	}
	
	public CandleStickChart createChartFromCryptoData() {
		// Bu metodu doldurmanizi bekliyoruz.
		CandleStickChart CandleStickChart = new CandleStickChart("BTC/USDT chart");
		List<Candle> candles;
		try {
		candles = this.cryptoDataCSVRepository.readCSV("Binance_BTCUSDT_d.csv");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		for (Candle candle : candles) {
			CandleStickChart.addCandle(
					candle.getTime(), candle.getOpen(),candle.getHigh(),
					candle.getLow(), candle.getClose(), candle.getVolume());
		}
			
		return CandleStickChart;
	}
}
