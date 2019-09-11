# _*_ coding: utf-8 _*_

from flask import Flask, request

app = Flask(__name__)

@app.route('/')
def root():
    parameter_dict = request.args.to_dict()
    if len(parameter_dict) == 0:
        return 'No parameter'

    parameters = ''
    for key in parameter_dict.keys():
        parameters += 'key: {}, value: {}<br>'.format(key, request.args[key])
    return parameters


if __name__ == '__main__':
    app.debug = True
    app.run()