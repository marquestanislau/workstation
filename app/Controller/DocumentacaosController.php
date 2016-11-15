<?php
App::uses('AppController', 'Controller');
/**
 * Documentacaos Controller
 *
 * @property Documentacao $Documentacao
 * @property PaginatorComponent $Paginator
 */
class DocumentacaosController extends AppController {

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
		$this->Documentacao->recursive = 0;
		$this->set('documentacaos', $this->Paginator->paginate());
	}

/**
 * view method
 *
 * @throws NotFoundException
 * @param string $id
 * @return void
 */
	public function view($id = null) {
		if (!$this->Documentacao->exists($id)) {
			throw new NotFoundException(__('Invalid documentacao'));
		}
		$options = array('conditions' => array('Documentacao.' . $this->Documentacao->primaryKey => $id));
		$this->set('documentacao', $this->Documentacao->find('first', $options));
	}

/**
 * add method
 *
 * @return void
 */
	public function add() {
		if ($this->request->is('post')) {
			$this->Documentacao->create();
			if ($this->Documentacao->save($this->request->data)) {
				$this->Flash->success(__('The documentacao has been saved.'));
				return $this->redirect(array('action' => 'index'));
			} else {
				$this->Flash->error(__('The documentacao could not be saved. Please, try again.'));
			}
		}
                $this->getKeys();
	}
        
        protected function getKeys() {
            $carreiras = $this->Documentacao->Carreira->find('list', array('fields' => 'Carreira.nome', 'Carreira.id'));
            $concursos = $this->Documentacao->Concurso->find('list', array('fields' => 'Concurso.data_aprovacao', 'Concurso.id'));
            $this->set(compact('carreiras', 'concursos'));
        }

        /**
 * edit method
 *
 * @throws NotFoundException
 * @param string $id
 * @return void
 */
	public function edit($id = null) {
		if (!$this->Documentacao->exists($id)) {
			throw new NotFoundException(__('Invalid documentacao'));
		}
		if ($this->request->is(array('post', 'put'))) {
			if ($this->Documentacao->save($this->request->data)) {
				$this->Flash->success(__('The documentacao has been saved.'));
				return $this->redirect(array('action' => 'index'));
			} else {
				$this->Flash->error(__('The documentacao could not be saved. Please, try again.'));
			}
		} else {
			$options = array('conditions' => array('Documentacao.' . $this->Documentacao->primaryKey => $id));
			$this->request->data = $this->Documentacao->find('first', $options);
		}
		$this->getKeys();
	}

/**
 * delete method
 *
 * @throws NotFoundException
 * @param string $id
 * @return void
 */
	public function delete($id = null) {
		$this->Documentacao->id = $id;
		if (!$this->Documentacao->exists()) {
			throw new NotFoundException(__('Invalid documentacao'));
		}
		$this->request->allowMethod('post', 'delete');
		if ($this->Documentacao->delete()) {
			$this->Flash->success(__('The documentacao has been deleted.'));
		} else {
			$this->Flash->error(__('The documentacao could not be deleted. Please, try again.'));
		}
		return $this->redirect(array('action' => 'index'));
	}
}
