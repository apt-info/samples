from upbitpy import Upbitpy

upbit = Upbitpy()

krw_markets = []
btc_markets = []
eth_markets = []
usdt_markets = []

markets = upbit.get_market_all()
for market in markets:
    if 'BTC-' in market['market']:
        btc_markets.append(market['market'])
    elif 'KRW-' in market['market']:
        krw_markets.append(market['market'])
    elif 'ETH-' in market['market']:
        eth_markets.append(market['market'])
    elif 'USDT-' in market['market']:
        usdt_markets.append(market['market'])
    else:
        print('unknown market: {}'.format(market['market']))

ticker = upbit.get_ticker(krw_markets)
for it in ticker:
    print('{}: {}원'.format(it['market'], it['trade_price']))

ticker = upbit.get_ticker(btc_markets)
for it in ticker:
    print('{}: {}'.format(it['market'], format(it['trade_price'], '.8f')))

ticker = upbit.get_ticker(eth_markets)
for it in ticker:
    print('{}: {}'.format(it['market'], format(it['trade_price'], '.8f')))

ticker = upbit.get_ticker(usdt_markets)
for it in ticker:
    print('{}: {}'.format(it['market'], format(it['trade_price'], '.8f')))
