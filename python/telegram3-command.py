# -*- coding: utf-8 -*-

import logging
from accounts import accounts
from telegram.ext import Updater, CommandHandler
from telegram import Update, Bot


TELEGRAM_BOT_TOKEN = accounts.TELEGRAM_DEV_DEMO_BOT


def start(bot: Bot, update: Update):
    logging.info('>>> start')
    bot.send_message(chat_id=update.message.chat_id, text='welcome...')


def stop(bot, update: Update):
    logging.info('>>> start')
    bot.send_message(chat_id=update.message.chat_id, text='bye...')


def send(bot, update: Update, args):
    logging.info('>>> send_args')
    received_args = 'received_args:'
    for arg in args:
        received_args += '\n - {}'.format(arg)
    bot.send_message(chat_id=update.message.chat_id, text=received_args)


def main():
    updater = Updater(TELEGRAM_BOT_TOKEN)
    updater.dispatcher.add_handler(CommandHandler('start', start))
    updater.dispatcher.add_handler(CommandHandler('stop', stop))
    updater.dispatcher.add_handler(CommandHandler('send', send, pass_args=True))
    updater.start_polling()
    updater.idle()


if __name__ == '__main__':
    logging.basicConfig(level=logging.INFO)
    main()
