<?php
App::uses('AppModel', 'Model');
/**
 * Carreira Model
 *
 */
class Carreira extends AppModel {

	public $name = 'Carreira';

/**
 * Validation rules
 *
 * @var array
 */
	public $validate = array(
		'nome' => array(
			'notBlank' => array(
				'rule' => array('notBlank'),
				//'message' => 'Your custom message here',
				//'allowEmpty' => false,
				//'required' => false,
				//'last' => false, // Stop validation after this rule
				//'on' => 'create', // Limit validation to 'create' or 'update' operations
			),
		),
	);

	public $hasMany = array(
		'Categoria' => array(
			'className' => 'Categoria',
			'foreignKey' => 'carreira_id',
		)	
	);
}
