'use strict';

module.exports = {
  up: (queryInterface, Sequelize) => {
      return queryInterface.bulkInsert('UserSkills', [{
        UserId: 2,
        SkillId: 1,
        createdAt: new Date(),
        updatedAt: new Date()
      },
      {
        UserId: 2,
        SkillId: 2,
        createdAt: new Date(),
        updatedAt: new Date()
      },
      {
        UserId: 3,
        SkillId: 3,
        createdAt: new Date(),
        updatedAt: new Date()
      },
      {
        UserId: 3,
        SkillId: 4,
        createdAt: new Date(),
        updatedAt: new Date()
      },
      {
        UserId: 4,
        SkillId: 1,
        createdAt: new Date(),
        updatedAt: new Date()
      },
      {
        UserId: 4,
        SkillId: 5,
        createdAt: new Date(),
        updatedAt: new Date()
      }
    ], {});
  },

  down: (queryInterface, Sequelize) => {
      return queryInterface.bulkDelete('UserSkills', null, {});
  }
};
