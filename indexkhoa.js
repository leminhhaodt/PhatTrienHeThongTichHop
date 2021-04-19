const http = require('http');
const express = require('express');
const app = express();
const bodyParser = require('body-parser')
const mongoose = require('mongoose');
var {Schema} = mongoose;
//const port = 3000;

//tạo schema
const Data = mongoose.model('Product', new Schema({ ProductName: String,Quantity:Number,Price:Number },{versionKey: false}));
//const Data = require('./model');

//Khai báo uri chính là đường dẫn tới db 
const uri = 'mongodb://localhost:27017/data';
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());



// Tạo kết nối tới DB
mongoose.connect(uri, {
        useNewUrlParser: true,
        useUnifiedTopology: true,
        useFindAndModify: false,
        useCreateIndex: true
    })
    //
    .then((db) => {
        console.log(`Kết nối database: ${uri}`);
    }).catch((err) => {
        console.log("Can't connect to database");
    });

//tạo mới: localhost:3000/post?ProductName=iphone&Quantity=99&Price=9999
app.post('/post', (req, res) => {
    
    var uadd = { id: req.query.id, 
        ProductName: req.query.ProductName, 
        Quantity: req.query.Quantity, 
        Price: req.query.Price }

    const data = new Data(uadd);

    data
        .save()
        .then(() => res.json(data))
        .catch((error) => {});
    console.log(data);
});

// tim theo ten của sp
app.get('/getname/:ProductName', function(req, res){
    
    Data.findOne({ProductName:req.params.ProductName},function(error, result) {
    //MyModel.find(function(error, result) {  
        if(error){
            res.end("loi");
        }
        else{
             res.json(result);
            // res.json(result[1]);
           // res.json(result[0].ProductName);
        }  
    });
});

//lấy toàn bộ mọi data 
app.get('/data', (req, res) => {
        Data.find()
            //muốn lấy trường nào thì để vào 
            .select('ProductName')
            .then((data) => {
                return res.status(200).json({
                    message: "Danh sach toan bo data",
                    Data: data
                })

            })
            .catch((err) => {
                res.status(500).json({
                    success: "false",
                    message: "Server ERROL"
                });
            })
    })

    //Tìm các obj có thuộc tính ProductName
app.get('/data/search', (req, res) => {
        Data.find({"ProductName":{$ne : null}})
            .exec((err, data) => {
                if (err) throw err;
                res.json({
                    message: `Ket qua tim kiem cho Obj co thuoc tinh ProductName: `,
                    Data: data
                })
            })

    })

    //Tìm bằng id, trường id này có thể không cần tạo cứ dùng _id tự phát của mgdb nha
app.get('/getid/:id', (req, res) => {
        id = req.params.id;
        Data.findById(id)
            .then((data) => {
                res.json({
                    message: `Ket qua tim kiem cho ID: ${id}`,
                    Data: data
                });
            })
            .catch((err) => {
                res.status(500).json({
                    success: "false",
                    message: "Server ERROL"
                })
            })
    })

    //PUT localhost:3000/update/607bc9e378db20242cccc3e5?ProductName=iphone&Quantity=99&Price=9999
app.put('/update/:id', (req, res) => {
        var input = {
            ProductName: req.query.ProductName, 
            Quantity: req.query.Quantity, 
            Price: req.query.Price }

       // console.log(req.body);
        const id = req.params.id;
        Data.updateOne({ _id: id }, { $set: input })
            .exec()
            .then(() => {
                res.json({
                    message: `Cap nhat thanh cong cho ID:${id}`,
                    data: input
                })
            })
            .catch((err) => {
                res.json({
                    success: false,
                    message: "Loi"
                })
            })
})


    //DELETE
app.delete('/delete/:id', (req, res) => {
    const id = req.params.id;
    Data.findByIdAndRemove(id)
        .exec()
        .then(() => res.json({
            success: true,
            message: `Xoa du lieu co id:${id} thanh cong`
        }))
        .catch((err) => {
            res.json({
                success: false,
            })
        })
})
// app.listen(port, (req, res) => {
//     console.log(`App listening at http://localhost:${port}`)
// });
app.listen(3000);