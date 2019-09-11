# _*_ coding: utf-8 _*_

from flask import Flask

app = Flask(__name__)

@app.route('/')
def root():
    return 'welcome to flask!'


@app.route('/sub')
def sub():
    return 'sub page'


if __name__ == '__main__':
    app.debug = True
    app.run()