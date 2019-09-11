# _*_ coding: utf-8 _*_

from flask import Flask, request
import json
import requests

app = Flask(__name__)

@app.route('/')
def root():
    return 'welcome to flask'


@app.route('/handle_post', methods=['POST'])
def handle_post():
    params = json.loads(request.get_data(), encoding='utf-8')
    if len(params) == 0:
        return 'No parameter'

    params_str = ''
    for key in params.keys():
        params_str += 'key: {}, value: {}<br>'.format(key, params[key])
    return params_str


@app.route('/send_post', methods=['GET'])
def send_post():
    params = {
        "param1": "test1",
        "param2": 123,
        "param3": "한글"
    }
    res = requests.post("http://127.0.0.1:5000/handle_post", data=json.dumps(params))
    return res.text


if __name__ == '__main__':
    app.debug = True
    app.run()