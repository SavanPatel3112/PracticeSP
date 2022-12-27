db.getCollection("bookPurchaseLog").aggregate([
  { $match: { softDelete: false } },
  {
    $lookup: {
      pipeline: [
        { $match: { $and: [{ $expr: { $eq: ["$_id", "$$userId"] } }] } },
      ],
      as: "student",
      from: "users",
      let: { userId: { $toObjectId: "$userId" } },
    },
  },
  { $unwind: { path: "$student" } },
  { $set: { fulName: "$student.fullName" } },
  { $unset: "student" },
  {
    $group: {
      bookData: {
        $push: {
          date: "$date",
          price: "$price",
          fullName: "$fulName",
          userId: "$userId",
        },
      },
      count: { $sum: 1 },
      _id: { bookName: "$bookName" },
    },
  },
]);
