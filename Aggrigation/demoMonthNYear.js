db.getCollection("bookPurchaseLog").aggregate([
  [
    { $set: { month: { $month: "$date" }, year: { $year: "$date" } } },
    { $match: { year: "2021" } },
    { $match: { month: "09" } },
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
    {
      $group: {
        price: { $sum: "$price" },
        count: { $sum: 1 },
        fullName: { $first: "$student.fullName" },
        _id: { userId: "$userId" },
        bookName: { $last: "$bookName" },
        bookId: { $last: "$bookId" },
      },
    },
    { $set: { userId: "$_id.userId" } },
    { $group: { _id: null, count: { $sum: 1 } } },
    { $project: { count: 1 } },
  ],
]);
