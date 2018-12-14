'use strict';

module.exports = {
  up: (queryInterface, Sequelize) => {
      return queryInterface.bulkInsert('Skills', [{
        title: 'Ruby on Rails',
        createdAt: new Date(),
        updatedAt: new Date()
      },
      {
        title: 'Ruby',
        createdAt: new Date(),
        updatedAt: new Date()
      },
      {
        title: 'AngularJS',
        createdAt: new Date(),
        updatedAt: new Date()
      },
      {
        title: 'NodeJS',
        createdAt: new Date(),
        updatedAt: new Date()
      },
      {
        title: 'Javascript',
        createdAt: new Date(),
        updatedAt: new Date()
      },
      {
        title: 'Java',
        createdAt: new Date(),
        updatedAt: new Date()
      },
      {
        title: 'Python',
        createdAt: new Date(),
        updatedAt: new Date()
      },
      {
        title: 'Django',
        createdAt: new Date(),
        updatedAt: new Date()
      },
      {
        title: 'Java Spring',
        createdAt: new Date(),
        updatedAt: new Date()
      },
      {
        title: 'React',
        createdAt: new Date(),
        updatedAt: new Date()
      }
    ], {});
    
  },

  down: (queryInterface, Sequelize) => {
      return queryInterface.bulkDelete('Skills', null, {});
  }
};
