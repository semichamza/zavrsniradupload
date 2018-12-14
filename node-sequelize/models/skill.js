'use strict';
module.exports = (sequelize, DataTypes) => {
  const Skill = sequelize.define('Skill', {
    title: {
      type: DataTypes.STRING,
      allowNull: false
    }
  }, {});
  Skill.associate = function(models) {
    // associations can be defined here
    Skill.belongsToMany(models.User, {
      through: 'UserSkill',
      as: 'users',
      foreign_key: 'skill_id'
    });
  };
  return Skill;
};