<?php
App::uses('AppModel', 'Model');
/**
 * Sectore Model
 *
 * @property Delegacao $Delegacao
 */
class Sectore extends AppModel {

/**
 * Validation rules
 *
 * @var array
 */
	public $validate = array(
		'designacao' => array(
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

	// The Associations below have been created with all possible keys, those that are not needed can be removed

/**
 * belongsTo associations
 *
 * @var array
 */
	public $belongsTo = array(
		'Delegacao' => array(
			'className' => 'Delegacao',
			'foreignKey' => 'delegacao_id',
			'conditions' => '',
			'fields' => '',
			'order' => ''
		)
	);
}
