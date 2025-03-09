const express = require('express');
const bodyParser = require('body-parser');
const mysql = require ('mysql2/promise');
const cors = require('cors');
const app = express();

app.use(bodyParser.json());
app.use(cors());
const port = 8000;

let users = []
let conn = null

/*
GET /users สำหรับ get ข้อมูล user ทั้งหมด
POST /user สำหรับสร้าง create user ใหม่บันทึกเข้าไป
PUT /user/:id สำหรับ update ข้อมูล user รายคนที่ต้องการบันทึกเข้าไป
DELETE /user/:id สำหรับลบ user รายคนที่ต้องการออกไป
GET /user/:id สำหรับ get ข้อมูล user รายคนที่ต้องการ
*/
// path = GET /users


app.get('/testdb', (req, res) => {
    mysql.createConnection({
        host: 'localhost',
        user: 'root',
        password:'root',
        database: 'webdb',
        port: 8830
    }).then((conn) => {
        conn
        .query('SELECT * FROM users')
        .then((results) => {
            res.json(results[0])
        })
        .catch((error) => {
            console.log('Error fetching users:', error.message)
            res.status(500).json({error: 'Error fetching users'})
        })
    })
 })
 
const initMySQL = async () => {
  conn = await mysql.createConnection({
      host: 'localhost',
      user: 'root',
      password:'root',
      database: 'webdb',
      port: 8830
  })
}

 app.get('/testdb-new', async (req, res) => {
  try {
        const results = await conn.query('SELECT * FROM users')
        res.json(results[0])
      } catch (error) {
        console.log('Error fetching users:', error.message)
        res.status(500).json({error: 'Error fetching users'})
  }
 })


 // path = GET /users/:id สำหรับ get user รายคนที่ต้องการดู
 app.get('/users/:id', async(req, res) => {
     try{
         let id = req.params.id;
         const results = await conn.query('SELECT * FROM users WHERE id = ?', id)
         if (results[0].length == 0) {
             throw {statusCode: 404, message: 'User not found'}
         }
         res.json(results[0][0])
     } catch (error) {
         console.error('errorMessage',error.message)
         let statusCode = error.statusCode || 500
         res.status(statusCode).json({
            message: 'something went wrong',
            errorMessage: error.message
         })
     }
 })

// path = POST / User สำหรับcreater user ใหม่บันทึกเข้าไป
app.post('/users', async (req,res) => {
    try{
        let user = req.body;
         const results = await conn.query('INSERT INTO users SET ?', user)
         res.json({
             message: 'User created',
             data: results[0]
         })
    } catch (error) {
        console.log('Error fetching users:', error.message)
        res.status(500).json({
            message: 'Something went wrong',
            errorMessage: error.message
        })
    }
})

// path = PUT / user/:id
app.put('/user/:id',async (req,res) => {
    let id = req.params.id;
    let updateUser = req.body;
    
    try{
        let user = req.body;
         const results = await conn.query(
            'UPDATE users SET ? WHERE id = ?',
            [updateUser, id]
        )
         res.json({
             message: 'Update User Completed',
             data: results[0]
         })
    } catch (error) {
        console.log('ErrorMessage', error.message)
        res.status(500).json({
            message: 'Something went wrong',
            errorMessage: error.message
        })
    }

    res.json({
        message: 'User updated successfully',
        data: {
            user: updateUser,
            indexUpdate: selectedIndex
        }
    });
    // sent user info in update to where it belongs
    /* 
    GET / USERS = get all users
    POST / USERS = create new user in data
    GET /users/:id = get user by id
    PUT /users/:id = get user by id
    */
 })

// Path = DELETE / user/:id
app.delete('/user/:id', async (req,res) => {
    try{
        let user = req.body;
         const results = await conn.query(
            'DELETE From users SET ? WHERE id = ?', id)
         res.json({
             message: 'Delete User Completed',
             data: results[0]
         })
    } catch (error) {
        console.log('ErrorMessage', error.message)
        res.status(500).json({
            message: 'Something went wrong',
            errorMessage: error.message
        })
    }
});

app.listen(port, async (req,res) => {
  await initMySQL()
    console.log(`Server is running on port`+ port);
});