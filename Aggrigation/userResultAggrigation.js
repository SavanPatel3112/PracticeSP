db.getCollection("user").aggregate([
  {
    $match: {
      userId: {
        $in: ["6304632fac7d94508596a6ef", "62f0eaa91dd83e487c4340de"],
      },
      softDelete: false,
    },
  },
  {
    $unwind: "$userResult",
  },
  {
    $match: {
      "userResult.semester": 1,
    },
  },
]);
