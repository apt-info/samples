from upbitpy import Upbitpy

class Upbit:
    def __init__(self):
        self.__upbit = Upbitpy()
        self.__krw_markets = self.__get_krw_markets()


    def __get_krw_markets(self):
        krw_markets = dict()
        all_markets = self.__upbit.get_market_all()
        for market in all_markets:
            if market['market'].startswith('KRW-'):
                krw_markets[market['market']] = market
        return krw_markets


    def get_hour_candles(self, market):
        if market not in self.__krw_markets.keys():
            return None
        candles = self.__upbit.get_minutes_candles(60, market, count=10)
        print(candles)
        return candles

