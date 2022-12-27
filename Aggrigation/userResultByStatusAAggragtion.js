db.getCollection("bookPurchaseLog").aggregate([
  {
    $match: {
      _id: { $in: [{ $oid: "62eb60ed9c735854c58f83de" }] },
      softDelete: false,
    },
  },
  { $unwind: "$results" },
  {
    $project: {
      status: {
        $switch: {
          branches: [
            { case: { $eq: ["$results.spi", 10.0] }, then: "firstClass" },
            { case: { $lt: ["$results.spi", 4.0] }, then: "fail" },
            {
              case: {
                $and: [
                  { $lt: ["$results.spi", 10.0] },
                  { $gte: ["$results.spi", 9.0] },
                ],
              },
              then: "secondClass",
            },
            {
              case: {
                $and: [
                  { $lt: ["$results.spi", 9.0] },
                  { $gte: ["$results.spi", 8.0] },
                ],
              },
              then: "thirdClass",
            },
            {
              case: {
                $and: [
                  { $lt: ["$results.spi", 8.0] },
                  { $gte: ["$results.spi", 7.0] },
                ],
              },
              then: "fourthClass",
            },
            {
              case: {
                $and: [
                  { $lt: ["$results.spi", 7.0] },
                  { $gte: ["$results.spi", 4.0] },
                ],
              },
              then: "fifthClass",
            },
          ],
          default: "none",
        },
      },
      fullName: 1.0,
      results: 1.0,
    },
  },
  {
    $group: {
      _id: "$_id",
      fullName: { $first: "$fullName" },
      result: {
        $push: {
          semester: "$results.semester",
          spi: "$results.spi",
          date: "$results.date",
          year: "$results.year",
          status: "$status",
        },
      },
    },
  },
]);
