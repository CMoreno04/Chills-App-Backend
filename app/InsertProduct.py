import mysql.connector

with open('/Users/cmoreno/Documents/Projects/chills-restaurant-midterm/src/assets/hamburger.jpg', 'rb') as imageFile:
    binary_data = imageFile.read()

cnx = mysql.connector.connect(user='root', password='rootroot',
                              host='127.0.0.1',
                              database='chillisdb')

cursor = cnx.cursor()

query = ("INSERT INTO FoodProduct "
         "(description, imageBlob, name, price) "
         "VALUES (%s, %s, %s, %s)")

data = ('Delicious burger with bacon, cheese, and veggies', 
        binary_data, 
        'Bacon Cheeseburger', 
        9.99)

cursor.execute(query, data)

cnx.commit()
cursor.close()
cnx.close()
