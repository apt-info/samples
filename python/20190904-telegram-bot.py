from telegram.ext import Updater

APT_INFO_TEST_BOT_TOKEN = '924028002:AAG4LznJkjaNNNwCFFFMO9iNDA2RhQ6-Jko'
CHAT_ID=

updater = Updater(APT_INFO_TEST_BOT_TOKEN)
updater.bot.send_message(chat_id=CHAT_ID, text='Hello telegram bot!')
