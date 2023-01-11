import sqlite3
from flask import Flask,request,jsonify,session
from flask import abort,redirect
app =Flask(__name__)
conn = sqlite3.connect('try.db')
cur = conn.cursor()
sql_text_1 = '''CREATE TABLE todolist
           (id int,
            title TEXT,
            content TEXT,
            state TEXT,
            time NUMBER,
            ddl NUMBER);'''
cur.execute(sql_text_1)
#插入一条待办事项
@app.route("/insert", methods=["POST"])
def insert():
    sql= "INSERT INTO todolist VALUES(1,'学习', '学数学', '否', 1.12, 1.13)"
    try:
        cur.execute(sql)
        return jsonify(code="200", msg="添加数据成功")
    except Exception as e:
        print(e)
        return jsonify(code="404", msg="添加数据失败")
#修改一条事项
@app.route("/put/one", methods=["PUT"])
def put_one():
    get_data = request.get_json()
    id = get_data.get("id")
    state = get_data.get("state")
    sql_text_1= "update todolist set state =%s where id=%s"
    try:
        cur.execute(sql_text_1)
        return jsonify(code="200", msg="修改成功")
    except Exception as e:
        print(e)
        return jsonify(code="404", msg="修改失败")
#修改全部事项
@app.route("/put/one", methods=["PUT"])
def put_one():
    get_data = request.get_json()
    id = get_data.get("id")
    state = get_data.get("state")
    sql_text_2= "update todolist set state =%s"
    try:
        cur.execute(sql_text_2)
        return jsonify(code="200", msg="修改成功")
    except Exception as e:
        print(e)
        return jsonify(code="404", msg="修改失败")
# 查询已完成
@app.route("/check/finish",methods=["GET"])
def check_finish():
    get_data = request.get_json()
    state = get_data.get("state")
    sql_text_3 = "SELECT * FROM todolist WHERE state=='是'"
    try :
         cur.execute(sql_text_3)
         return jsonify(code="200", msg=cur.fetchall())
    except Exception as e:
         print(e)
         return jsonify(code="404",msg="查询错误")
 #查询未完成
@app.route("/check/unfinish", methods=["GET"])
def check_unfinish():
    get_data = request.get_json()
    state = get_data.get("state")
    sql_text_4 = "SELECT * FROM todolist WHERE state=='否'"
    try:
        cur.execute(sql_text_4)
        return jsonify(code="200", msg=cur.fetchall())
    except Exception as e:
        print(e)
        return jsonify(code="404", msg="查询错误")
 #查询所有
@app.route("/check/all", methods=["GET"])
def check_all():
    get_data = request.get_json()
    state = get_data.get("state")
    sql_text_5 = "SELECT * FROM todolist "
    try:
        cur.execute(sql_text_5)
        return jsonify(code="200", msg=cur.fetchall())
    except Exception as e:
        print(e)
        return jsonify(code="404", msg="查询错误")
#根据关键字查询
@app.route("/check/some", methods=["GET"])
def check_some():
    get_data = request.get_json()
    title = get_data.get("title")
    sql_text_6 = "SELECT * FROM todolist WHERE title==%s "
    try:
        cur.execute(sql_text_6)
        return jsonify(code="200", msg=cur.fetchall())
    except Exception as e:
        print(e)
        return jsonify(code="404", msg="你想要查询的数据不存在")
#根据id查询
@app.route("/check/id", methods=["GET"])
def check_id():
    get_data = request.get_json()
    id = get_data.get("id")
    sql_text_7 = "SELECT * FROM todolist WHERE id==%s "
    try:
        cur.execute(sql_text_7)
        return jsonify(code="200", msg=cur.fetchall())
    except Exception as e:
        print(e)
        return jsonify(code="404", msg="你想要查询的id不存在")
#删除一条数据
@app.route("/delete/one",methods=["DELETE"])
def delete_one():
    get_data = request.get_json()
    id = get_data.get("id")
    sql_text_8="delete from todolist where id=%s"
    try:
        cur.execute(sql_text_8)
        return jsonify(code="200", msg="删除成功")
    except Exception as e:
        print(e)
        return jsonify(code="404", msg="删除失败")
#删除多条数据
@app.route("/delete/many",methods=["DELETE"])
def delete_many():
    get_data = request.get_json()
    id = get_data.get("id")
    state=get_data.get("state")
    sql_text_9="delete from todolist where state=%s"
    try:
        cur.execute(sql_text_9)
        return jsonify(code="200", msg="删除成功")
    except Exception as e:
        print(e)
        return jsonify(code="404", msg="删除失败")
#删除所有数据
@app.route("/delete/all",methods=["DELETE"])
def delete_all():
    sql_text_10="delete from todolist"
    try:
        cur.execute(sql_text_10)
        return jsonify(code="200", msg="删除成功")
    except Exception as e:
        print(e)
        return jsonify(code="404", msg="删除失败")
app.run(host="0.0.0.0")
cur.close()
conn.close()
