<div class="documentacaos view">
<h2><?php echo __('Documentacao'); ?></h2>
	<dl>
		<dt><?php echo __('Id'); ?></dt>
		<dd>
			<?php echo h($documentacao['Documentacao']['id']); ?>
			&nbsp;
		</dd>
		<dt><?php echo __('Nome'); ?></dt>
		<dd>
			<?php echo h($documentacao['Documentacao']['nome']); ?>
			&nbsp;
		</dd>
		<dt><?php echo __('Carreira'); ?></dt>
		<dd>
			<?php echo $this->Html->link($documentacao['Carreira']['id'], array('controller' => 'carreiras', 'action' => 'view', $documentacao['Carreira']['id'])); ?>
			&nbsp;
		</dd>
		<dt><?php echo __('Concurso'); ?></dt>
		<dd>
			<?php echo $this->Html->link($documentacao['Concurso']['id'], array('controller' => 'concursos', 'action' => 'view', $documentacao['Concurso']['id'])); ?>
			&nbsp;
		</dd>
	</dl>
</div>
<div class="actions">
	<h3><?php echo __('Actions'); ?></h3>
	<ul>
		<li><?php echo $this->Html->link(__('Edit Documentacao'), array('action' => 'edit', $documentacao['Documentacao']['id'])); ?> </li>
		<li><?php echo $this->Form->postLink(__('Delete Documentacao'), array('action' => 'delete', $documentacao['Documentacao']['id']), array('confirm' => __('Are you sure you want to delete # %s?', $documentacao['Documentacao']['id']))); ?> </li>
		<li><?php echo $this->Html->link(__('List Documentacaos'), array('action' => 'index')); ?> </li>
		<li><?php echo $this->Html->link(__('New Documentacao'), array('action' => 'add')); ?> </li>
		<li><?php echo $this->Html->link(__('List Carreiras'), array('controller' => 'carreiras', 'action' => 'index')); ?> </li>
		<li><?php echo $this->Html->link(__('New Carreira'), array('controller' => 'carreiras', 'action' => 'add')); ?> </li>
		<li><?php echo $this->Html->link(__('List Concursos'), array('controller' => 'concursos', 'action' => 'index')); ?> </li>
		<li><?php echo $this->Html->link(__('New Concurso'), array('controller' => 'concursos', 'action' => 'add')); ?> </li>
	</ul>
</div>
