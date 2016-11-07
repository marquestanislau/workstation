<div class="mdl-cell mdl-cell--10-col">
	
	<ul class="demo-list-item mdl-list">
	  <li class="mdl-list__item">
	    <span class="mdl-list__item-primary-content">
	    	<i class="material-icons mdl-list__item-icon">person</i>
	      	Lista de Utilizadores regitados no sistema
	    </span>
	  </li>
	</ul>
	<hr>
	<?php echo $this->Form->create('Usuario', array('controller' => 'UsuariosController', 'url' => 'index')); ?>
	<div class="form-group">
		<div class="input-group">
    		<input type="text" class="form-control" placeholder="Digite o nome ou apelido...">
    		<span class="input-group-btn">
        		<button class="btn btn-default" type="submit">
        			<span class="glyphicon glyphicon-search"></span>
        			Procurar!
        		</button>
      		</span>
    	</div>
	</div>
	<?php echo $this->Form->end(); ?>
	<table class="table table-striped" cellpadding="0" cellspacing="0">
	<thead>
	<tr>
			<th><?php echo $this->Paginator->sort('id'); ?></th>
			<th><?php echo $this->Paginator->sort('nome'); ?></th>
			<th><?php echo $this->Paginator->sort('apelido'); ?></th>
			<th><?php echo $this->Paginator->sort('email'); ?></th>
			<th><?php echo $this->Paginator->sort('contacto'); ?></th>
			<th class="actions"><?php echo __('Actions'); ?></th>
	</tr>
	</thead>
	<tbody>
	<?php foreach ($usuarios as $usuario): ?>
	<tr>
		<td><?php echo h($usuario['Usuario']['id']); ?>&nbsp;</td>
		<td><?php echo h($usuario['Usuario']['nome']); ?>&nbsp;</td>
		<td><?php echo h($usuario['Usuario']['apelido']); ?>&nbsp;</td>
		<td><?php echo h($usuario['Usuario']['email']); ?>&nbsp;</td>
		<td><?php echo h($usuario['Usuario']['contacto']); ?>&nbsp;</td>
		<td class="actions">
			<?php echo $this->Html->link(__('View'), array('action' => 'view', $usuario['Usuario']['id']), array('class' => 'btn btn-default')); ?>
			<?php echo $this->Html->link(__('Edit'), array('action' => 'edit', $usuario['Usuario']['id']), array('class' => 'btn btn-default')); ?>
			<?php echo $this->Form->postLink(__('Delete'), array('action' => 'delete', $usuario['Usuario']['id']), array('class' => 'btn btn-default', 'confirm' => __('Are you sure you want to delete # %s?', $usuario['Usuario']['id']))); ?>
		</td>
	</tr>
<?php endforeach; ?>
	</tbody>
	</table>
	<p>
	<?php
	echo $this->Paginator->counter(array(
		'format' => __('Pagina {:page} de {:pages}, a visualizar {:current} registos num total de {:count}, inicia em {:start},  e termina em {:end}')
	));
	?>	</p>
	<div class="pagination">
	<?php
		echo $this->Paginator->prev('<< ' . __('Anterior'), array(), null, array('class' => 'btn btn-primary'));
		echo $this->Paginator->numbers(array('separator' => ''));
		echo $this->Paginator->next(__('Proximo') . ' >>', array(), null, array('class' => 'btn btn-warning'));
	?>
	</div>
</div>
<div class="mdl-cell mdl-cell--2-col">
	<h3><?php echo __('Atividade'); ?></h3>
	<?php echo $this->Html->link(__('Novo Utilizador'), array('action' => 'add'), array('class' => 'mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect')); ?>
	
</div>
