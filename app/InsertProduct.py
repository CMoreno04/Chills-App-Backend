import pymysql

# Combined list
products = [
    {"name": "Mozzarella Sticks", "price": 5.99, "description": "A classic appetizer made with breaded mozzarella cheese served with marinara sauce.", "imageUrl": "images/mozzarella_sticks.jpg"},
    {"name": "Hamburger", "price": 8.99, "description": "A classic hamburger made with our house blend of beef, served with lettuce, tomato, and onion and melted cheese.", "imageUrl": "images/hamburger.jpg"},
    {"name": "Pepperoni Pizza", "price": 14.99, "description": "A classic pizza topped with tomato sauce, mozzarella cheese, and pepperoni.", "imageUrl": "images/pepperoni-pizza.jpg"},
    {"name": "French Fries", "price": 3.99, "description": "A side of crispy french fries.", "imageUrl": "images/french-fries.jpg"},
    {"name": "Tiramisu", "price": 5.99, "description": "A classic Italian dessert made with ladyfingers, mascarpone, and espresso.", "imageUrl": "images/tiramisu.jpg"},
    {"name": "Coca-Cola", "price": 2.99, "description": "A can of Coca-Cola.", "imageUrl": "images/coca-cola.jpg"}
]

# Load image blobs directly into products
for product in products:
    with open(product["imageUrl"], 'rb') as imageFile:
        product["imageBlob"] = imageFile.read()

# Using context managers to manage connection and cursor
with pymysql.connect(host='127.0.0.1', user='root', password='rootroot', database='chillisdb') as connection:
    with connection.cursor() as cursor:
        sql = "INSERT INTO FoodProduct (name, price, description, imageBlob) VALUES (%s, %s, %s, %s)"
        
        # Bulk insert using executemany
        cursor.executemany(sql, [(product["name"], product["price"], product["description"], product["imageBlob"]) for product in products])
        
        # Commit the changes
        connection.commit()
