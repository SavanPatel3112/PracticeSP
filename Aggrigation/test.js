db.getCollection("bookPurchaseLog").aggregate([
  {
    $match: {
      userId: {
        $in: ["62eb60ed9c735854c58f83de", "62eb607d9c735854c58f83dd"],
      },
      softDelete: false,
    },
  },
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
  { $set: { fulName: "$student.fullName", balance: "$student.balance" } },
  { $unset: "student" },
  { $group: { _id: null, count: { $sum: 1 } } },
  { $project: { count: 1 } },
]);
