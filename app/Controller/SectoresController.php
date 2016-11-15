<?php
App::uses('AppController', 'Controller');
/**
 * Sectores Controller
 *
 * @property Sectore $Sectore
 * @property PaginatorComponent $Paginator
 */
class SectoresController extends AppController {

/**
 * Components
 *
 * @var array
 */
	public $components = array('Paginator', 'Flash', 'Session');

/**
 * index method
 *
 * @return void
 */
	public function index() {
		$this->Sectore->recursive = 0;
		$this->set('sectores', $this->Paginator->paginate());
	}

/**
 * view method
 *
 * @throws NotFoundException
 * @param string $id
 * @return void
 */
	public function view($id = null) {
		if (!$this->Sectore->exists($id)) {
			throw new NotFoundException(__('Invalid sectore'));
		}
		$options = array('conditions' => array('Sectore.' . $this->Sectore->primaryKey => $id));
		$this->set('sectore', $this->Sectore->find('first', $options));
	}

/**
 * add method
 *
 * @return void
 */
	public function add() {
		if ($this->request->is('post')) {
			$this->Sectore->create();
			if ($this->Sectore->save($this->request->data)) {
				$this->Flash->success(__('The sectore has been saved.'));
				return $this->redirect(array('action' => 'index'));
			} else {
				$this->Flash->error(__('The sectore could not be saved. Please, try again.'));
			}
		}
                $this->colocaNome();
	}

        protected function colocaNome() {
            $delegacaos = $this->Sectore->Delegacao->find('list', array('fields' => 'Delegacao.nome', 'Delegacao.id'));
            $this->set(compact('delegacaos'));
        }
/**
 * edit method
 *
 * @throws NotFoundException
 * @param string $id
 * @return void
 */
	public function edit($id = null) {
		if (!$this->Sectore->exists($id)) {
			throw new NotFoundException(__('Invalid sectore'));
		}
		if ($this->request->is(array('post', 'put'))) {
			if ($this->Sectore->save($this->request->data)) {
				$this->Flash->success(__('The sectore has been saved.'));
				return $this->redirect(array('action' => 'index'));
			} else {
				$this->Flash->error(__('The sectore could not be saved. Please, try again.'));
			}
		} else {
			$options = array('conditions' => array('Sectore.' . $this->Sectore->primaryKey => $id));
			$this->request->data = $this->Sectore->find('first', $options);
		}
		$this->colocaNome();
	}

/**
 * delete method
 *
 * @throws NotFoundException
 * @param string $id
 * @return void
 */
	public function delete($id = null) {
		$this->Sectore->id = $id;
		if (!$this->Sectore->exists()) {
			throw new NotFoundException(__('Invalid sectore'));
		}
		$this->request->allowMethod('post', 'delete');
		if ($this->Sectore->delete()) {
			$this->Flash->success(__('The sectore has been deleted.'));
		} else {
			$this->Flash->error(__('The sectore could not be deleted. Please, try again.'));
		}
		return $this->redirect(array('action' => 'index'));
	}
}
