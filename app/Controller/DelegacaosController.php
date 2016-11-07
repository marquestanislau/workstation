<?php
App::uses('AppController', 'Controller');
/**
 * Delegacaos Controller
 *
 * @property Delegacao $Delegacao
 * @property PaginatorComponent $Paginator
 */
class DelegacaosController extends AppController {

/**
 * Components
 *
 * @var array
 */
	public $components = array('Paginator', 'Session', 'Flash');

/**
 * index method
 *
 * @return void
 */
	public function index() {
		$this->Delegacao->recursive = 0;
		$this->set('delegacaos', $this->Paginator->paginate());
	}

/**
 * view method
 *
 * @throws NotFoundException
 * @param string $id
 * @return void
 */
	public function view($id = null) {
		if (!$this->Delegacao->exists($id)) {
			throw new NotFoundException(__('Invalid delegacao'));
		}
		$options = array('conditions' => array('Delegacao.' . $this->Delegacao->primaryKey => $id));
		$this->set('delegacao', $this->Delegacao->find('first', $options));
	}

/**
 * add method
 *
 * @return void
 */
	public function add() {
		if ($this->request->is('post')) {
			$this->Delegacao->create();
			if ($this->Delegacao->save($this->request->data)) {
				$this->Flash->success(__('The delegacao has been saved.'));
				return $this->redirect(array('action' => 'index'));
			} else {
				$this->Flash->error(__('The delegacao could not be saved. Please, try again.'));
			}
		}
	}

/**
 * edit method
 *
 * @throws NotFoundException
 * @param string $id
 * @return void
 */
	public function edit($id = null) {
		if (!$this->Delegacao->exists($id)) {
			throw new NotFoundException(__('Invalid delegacao'));
		}
		if ($this->request->is(array('post', 'put'))) {
			if ($this->Delegacao->save($this->request->data)) {
				$this->Flash->success(__('The delegacao has been saved.'));
				return $this->redirect(array('action' => 'index'));
			} else {
				$this->Flash->error(__('The delegacao could not be saved. Please, try again.'));
			}
		} else {
			$options = array('conditions' => array('Delegacao.' . $this->Delegacao->primaryKey => $id));
			$this->request->data = $this->Delegacao->find('first', $options);
		}
	}

/**
 * delete method
 *
 * @throws NotFoundException
 * @param string $id
 * @return void
 */
	public function delete($id = null) {
		$this->Delegacao->id = $id;
		if (!$this->Delegacao->exists()) {
			throw new NotFoundException(__('Invalid delegacao'));
		}
		$this->request->allowMethod('post', 'delete');
		if ($this->Delegacao->delete()) {
			$this->Flash->success(__('The delegacao has been deleted.'));
		} else {
			$this->Flash->error(__('The delegacao could not be deleted. Please, try again.'));
		}
		return $this->redirect(array('action' => 'index'));
	}
}
