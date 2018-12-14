'use strict';

module.exports = {
  up: (queryInterface, Sequelize) => {
      return queryInterface.bulkInsert('Users', [{
        username: 'admin',
        password: '$2a$12$rMO5BYjd2ZNvzhAVQ5cEeuGGfsCgRmTtqSKm8KMxpTLOFItskR2A2',
        mail: 'admin@etf.unsa.ba',
        createdAt: new Date(),
        updatedAt: new Date()
      },
      {
        username: 'user1',
        password: '$2a$12$/Xpd59W0F854Y5R6jGEZde4PBpqdazmGmldRxLvDvhGV48sajM2jO',
        mail: 'user1@etf.unsa.ba',
        createdAt: new Date(),
        updatedAt: new Date()
      },
      {
        username: 'user2',
        password: '$2a$12$Py3p4J2Av9FWG06htmDd3.1B1lWjQO/H0VTtiKgOKuBpmn5iZmoLW',
        mail: 'user2@etf.unsa.ba',
        createdAt: new Date(),
        updatedAt: new Date()
      },
      {
        username: 'user3',
        password: '$2a$12$O4yiF46kJtpi1Xppi8Gsx.BPPc5EjM9NXu2YbNN7VjLYsfZ1MEPzW',
        mail: 'user3@etf.unsa.ba',
        createdAt: new Date(),
        updatedAt: new Date()
      }
    ], {});
    
  },

  down: (queryInterface, Sequelize) => {
      return queryInterface.bulkDelete('Users', null, {});
    
  }
};
