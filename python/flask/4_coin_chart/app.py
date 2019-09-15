# _*_ coding: utf-8 _*_

import logging
from upbit import Upbit
from flask import Flask, request, render_template

app = Flask(__name__)
upbit = Upbit()
upbit.get_hour_candles('KRW-BTC')

@app.route('/')
def root():
    market = request.args.get('market')
    if market is None or market == '':
        return 'No market parameter'

    candles = upbit.get_hour_candles(market)
    if candles is None:
        return 'invalid market: {}'.format(market)

    label = market
    xlabels = []
    dataset = []
    i = 0
    for candle in candles:
        xlabels.append('')
        dataset.append(candle['trade_price'])
        i += 1
    return render_template('chart.html', **locals())

def main():
    app.debug = True
    app.run()


if __name__ == '__main__':
    main()
