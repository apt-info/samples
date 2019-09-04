from telegram.ext import Updater
from accounts import accounts
from telegram.ext import Updater
from upbitpy import Upbitpy
import time
import datetime
import logging

INTERVAL_MIN = 60
CHAT_ID = accounts.TELEGRAM_MY_CHAT_ID
TELEGRAM_BOT_TOKEN = accounts.TELEGRAM_DEV_DEMO_BOT

def wait(min):
    now = datetime.datetime.now()
    remain_second = 60 - now.second
    remain_second += 60 * (min - (now.minute % min + 1))
    time.sleep(remain_second)


def main():
    upbit = Upbitpy()
    updater = Updater(TELEGRAM_BOT_TOKEN)

    while True:
        ticker = upbit.get_ticker(['KRW-BTC'])[0]
        price_str = format(int(ticker['trade_price']), ',')
        text = '({}) 비트코인 가격: {} 원'.format(datetime.datetime.now().strftime('%m/%d %H:%M:%S'), price_str)
        updater.bot.send_message(chat_id=CHAT_ID, text=text)
        wait(INTERVAL_MIN)


if __name__ == '__main__':
    logging.basicConfig(level=logging.INFO)
    main()
