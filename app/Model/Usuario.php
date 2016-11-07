<?php
App::uses('AppModel', 'Model');
/**
 * Usuario Model
 *
 */
class Usuario extends AppModel {

/**
 * Display field
 *
 * @var string
 */
	public $displayField = 'nome';

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
		'apelido' => array(
			'notBlank' => array(
				'rule' => array('notBlank'),
				//'message' => 'Your custom message here',
				//'allowEmpty' => false,
				//'required' => false,
				//'last' => false, // Stop validation after this rule
				//'on' => 'create', // Limit validation to 'create' or 'update' operations
			),
		),
		'email' => array(
			'email' => array(
				'rule' => array('email'),
				//'message' => 'Your custom message here',
				//'allowEmpty' => false,
				//'required' => false,
				//'last' => false, // Stop validation after this rule
				//'on' => 'create', // Limit validation to 'create' or 'update' operations
			),
		),
		'data_de_registo' => array(
			'date' => array(
				'rule' => array('date'),
				//'message' => 'Your custom message here',
				//'allowEmpty' => false,
				//'required' => false,
				//'last' => false, // Stop validation after this rule
				//'on' => 'create', // Limit validation to 'create' or 'update' operations
			),
		),
		'contacto' => array(
			'notBlank' => array(
				'rule' => array('notBlank'),
				//'message' => 'Your custom message here',
				//'allowEmpty' => false,
				//'required' => false,
				//'last' => false, // Stop validation after this rule
				//'on' => 'create', // Limit validation to 'create' or 'update' operations
			),
		),
		'foto_perfil' => array(
			'uploadError' => array(
				'rule' => 'uploadError',
				'message' => 'Ocorreu um erro ao carregar a imagem.',
				'allowEmpty' => TRUE,
			),
			'mimeType' => array(
				'rule' => array('mimeType', array('image/gif', 'image/png', 'image/jpg', 'image/jpeg')),
				'message' => 'O sistema apenas suporta os formatos (gif, png, jpg).',
				'allowEmpty' => TRUE,
			),
			'fileSize' => array(
				'rule' => array('fileSize', '<=', '1MB'),
				'message' => 'A imagem nao deve exceder 1MB em tamanho.',
				'allowEmpty' => TRUE,	
			),
			'proccessCoverUpload' => array(
				'rule' => 'proccessCoverUpload',
				'message' => 'Nao foi possivel processar a imagem para upload.',
				'allowEmpty' => TRUE,
			),
		),
	);

	public function proccessCoverUpload($check = array()) {
		if (!is_uploaded_file($check['foto_perfil']['tmp_name'])) {
			return FALSE; 
		} 
		if (!move_uploaded_file($check['foto_perfil']['tmp_name'], WWW_ROOT . 'img' . '/' . 'upload' . '/' . $check['foto_perfil']['name'])) {
			return FALSE;
		}
		$this->data[$this->alias]['foto_perfil'] = 'upload' . '/' . $check['foto_perfil']['name'];
		return TRUE;
	}
}
